import joblib


class Predictor:

    def __init__(self):
        self.model = joblib.load('../data/model.pkl')

    def predict_fake(self, user_data):
        print(self.model.predict(user_data))
        return self.model.predict(user_data)
