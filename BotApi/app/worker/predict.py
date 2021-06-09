import joblib
import pandas as pd
DATASET_DEFINE = 'profile pic,nums/length username,fullname words,nums/length fullname,name==username,description ' \
                 'length,external URL,private,#posts,#followers,#follows,fake\n'


def load_data_to_buffer(data):
    print(data)
    with open('data/buffer.csv', 'w') as outf:
        outf.writelines([DATASET_DEFINE, data])


class Predictor:

    def __init__(self):
        self.model = joblib.load('data/model.pkl')

    def predict_fake(self, user_data):
        load_data_to_buffer(user_data)
        test_data = pd.read_csv('data/buffer.csv', header=0)
        X_test = test_data.drop(columns='fake')
        print(self.model.predict_proba(X_test))
        result = self.model.predict_proba(X_test)
        if result[0][0] > result[0][1]:
            answer = {"answer": False, "prob": str(result[0][0])}
        else:
            answer = {"answer": True, "prob": str(result[0][1])}
        return answer
