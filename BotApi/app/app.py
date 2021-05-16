from flask import Flask, render_template

from worker.predict import Predictor

app = Flask(__name__)
util = Predictor()


@app.route('/')
def index():
    return render_template('index.html')


@app.route("/predictFakeUser/", methods=['POST'])
def predict_fake(username):
    answer = util.predict_fake(username)
    print('OK')
    return answer


if __name__ == '__main__':
    app.run(debug=True)
