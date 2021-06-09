from flask import Flask, render_template

from worker.predict import Predictor

app = Flask(__name__)
util = Predictor()


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/predictFakeUser/<userdata>', methods=['POST', 'GET'])
def predict_fake(userdata):
    answer = util.predict_fake(userdata)
    print('OK')
    return answer


@app.route('/test')
def test():
    answer = util.predict_fake("1,0.25,2,0.0,0,0,0,1,0,43,205,0")
    return answer


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=8097)
