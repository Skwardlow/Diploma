import joblib
import numpy as np
import pandas as pd
import seaborn as sns
from sklearn.model_selection import cross_validate
from sklearn.metrics import confusion_matrix
from sklearn.pipeline import Pipeline
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import GridSearchCV
from sklearn.metrics import classification_report
from sklearn.linear_model import LogisticRegression
from sklearn.ensemble import RandomForestClassifier, GradientBoostingClassifier
from sklearn.svm import SVC
from sklearn.naive_bayes import GaussianNB
from sklearn.model_selection import train_test_split


def load_train_data():
    ''' Load data from csv files, Train data
        Splits data into X (feature matrix) and y (labels)

        returns: X_train, y_train

    '''
    train_data = pd.read_csv('../data/instagram-fake-spammer-genuine-accounts/train.csv', header=0)

    X_train = train_data.drop(columns='fake')
    y_train = train_data['fake']

    return X_train, y_train


def load_test_data():
    ''' Load data from csv files, Train and Test data
        Splits data into X (feature matrix) and y (labels)

        returns: X_test, y_test

    '''
    test_data = pd.read_csv('../data/instagram-fake-spammer-genuine-accounts/test.csv', header=0)

    X_test = test_data.drop(columns='fake')
    y_test = test_data['fake']

    return X_test, y_test


def get_classifier_cv_score(model, X, y, scoring='accuracy', cv=7):
    '''Calculate train and validation score of classifier (model) using cross-validation


        model (sklearn classifier): Classifier to train and evaluate
        X (numpy.array or pandas.DataFrame): Feature matrix
        y (numpy.array or pandas.Series): Target vector
        scoring (str): a scoring string accepted by sklearn.metrics.cross_validate()
        cv (int): number of cross-validation folds see sklearn.metrics.cross_validate()

        returns: mean training score, mean validation score

    '''
    scores = cross_validate(model, X, y, cv=cv, scoring=scoring, return_train_score=True)
    train_scores = scores['train_score']
    val_scores = scores['test_score']

    train_mean = np.mean(train_scores)
    val_mean = np.mean(val_scores)

    return train_mean, val_mean


def print_grid_search_result(grid_search):
    '''Prints best parameters and mean training and validation scores of a grid search object.

        grid_search (sklearn GridSearchCV): Fitted GridSearchCV object

        scores are printed with 3 decimal places.

    '''

    # TODO: implement function body

    print(grid_search.best_params_)

    best_train = grid_search.cv_results_["mean_train_score"][grid_search.best_index_]
    print("best mean_train_score: {:.3f}".format(best_train))

    best_test = grid_search.cv_results_["mean_test_score"][grid_search.best_index_]
    print("best mean_test_score: {:.3f}".format(best_test))


def plot_confusion_matrix(y_actual, y_pred, labels, title=''):
    '''Creates a heatmap plot of the confusion matrix.

        y_actual (pandas.DataSeries or numpy.Array): Ground truth label vector
        y_pred (pandas.DataSeries or numpy.Array): Predicted label vector
        labels (list(str)): Class names used for plotting (ticklabels)
        title (str): Plot title

        uses sklearn.metrics.confusion_matrix

    '''
    data = confusion_matrix(y_actual, y_pred)
    ax = sns.heatmap(data,
                     annot=True,
                     cbar=False,
                     fmt='d',
                     xticklabels=labels,
                     yticklabels=labels)
    ax.set_title(title)
    ax.set_xlabel("predicted values")
    ax.set_ylabel("actual values")
    ax.figure.show()


X_data, y_data = load_train_data()
print(X_data.info())

X_data.head()

print("Size: ", X_data.shape, ", Type: ", type(X_data))
print("Size: ", y_data.shape, ", Type: ", type(y_data))

data_corr = X_data.corr(method='pearson')
ax = sns.heatmap(data_corr, vmin=-1, vmax=1, cmap='BrBG')
ax.set_title("Correlation Heatmap Between Features")

print(X_data.isnull().sum())

unique, freq = np.unique(y_data, return_counts=True)

for i, j in zip(unique, freq):
    print("Label: ", i, ", Frequency: ", j)

# ------------------------------------------------------------------

X_train, X_test, y_train, y_test = train_test_split(X_data, y_data, test_size=0.2, random_state=37)

print(X_train.shape)
print(y_train.shape)

# -------------------------------------------------------------------------------------

model_list = [LogisticRegression(max_iter=600),
              SVC(),
              GaussianNB(),
              RandomForestClassifier(random_state=55),
              GradientBoostingClassifier(random_state=56)]

train_scores = []
val_scores = []

for model in model_list:
    train, val = get_classifier_cv_score(model, X_train, y_train, 'average_precision')
    train_scores.append(train)
    val_scores.append(val)

models_score = sorted(list(zip(val_scores, train_scores, model_list)), reverse=True)

print("-------------------------------------")
for val, train, model in models_score:
    print("Model: {} ".format(model.__class__.__name__))

    print("train_score: {:.3f}".format(train))

    print("validation_score: {:.3f}".format(val))

    print("-------------------------------------")

# ---------------------------------------------------------------
import os

# if run on own computer
# num_cpu = int(os.environ['NUMBER_OF_PROCESSORS'])

model = RandomForestClassifier(random_state=55)

parameters = {'n_estimators': [300, 500, 700, 1000],
              'max_depth': [7, 9, 11, 13]}

# if run on own computer
# grid1 = GridSearchCV(model, parameters, cv=7, scoring='average_precision', n_jobs=num_cpu, return_train_score=True)
grid1 = GridSearchCV(model, parameters, cv=7, scoring='average_precision', return_train_score=True)

grid1.fit(X_train, y_train)

print_grid_search_result(grid1)

model = GradientBoostingClassifier(max_depth=5, random_state=56)

parameters = {'n_estimators': [50, 100, 200],
              'learning_rate': [0.001, 0.01, 0.1, 1.0, 10.0]}

# if run on own computer
# grid2 = GridSearchCV(model, parameters, cv=7, scoring='average_precision', n_jobs=num_cpu, return_train_score=True)
grid2 = GridSearchCV(model, parameters, cv=7, scoring='average_precision', return_train_score=True)

grid2.fit(X_train, y_train)

print_grid_search_result(grid2)

# -----------------------------------------------------------------------------
pipeline = Pipeline([('preprocessing', StandardScaler()), ('classifier', grid1.best_estimator_)])
pipeline.fit(X_train, y_train)

print("Test score: {:.3f}".format(pipeline.score(X_test, y_test)))

X_final, y_final = load_test_data()

print("Test score: {:.3f}".format(pipeline.score(X_final, y_final)))

# ----------------------------------------------------------------------
y_pred = pipeline.predict(X_final)
print(classification_report(y_final, y_pred, target_names=["genuine", "fake"]))

labels = ["genuine", "fake"]
title = "Predicting Fake Instagram Account"
plot_confusion_matrix(y_final, y_pred, labels, title)

data_corr = X_data.corr(method='pearson')
ax = sns.heatmap(data_corr, vmin=-1, vmax=1, cmap='BrBG')
ax.set_title("Correlation Heatmap Between Features")

model.fit(X_train, y_train)
joblib.dump(model, '../data/model.pkl')
tst_mdl = joblib.load('../data/model.pkl')
