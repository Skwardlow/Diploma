[![Build Status](https://travis-ci.com/Skwardlow/Diploma.svg?token=KCkKDpGCxsPEM3xKfkFv&branch=master)](https://travis-ci.com/github/Skwardlow/Diploma)

# InstaBotDetector

##### This service is intended to help in determining whether the profile of the social network Instagram belongs to the class of bots. Determination of belonging is based on a neural network specially trained on a dataset of bots accounts, that allows it make a decision.
 1. It's simple. Start the service-side, predictor-side as above.
 2. Open the web application page.
 3. You will be presented with one input field and a "Check" button, by clicking on which, after a short period of time, you will receive the result.
 4. Enter the name of your Instagram account, click the button and get the result!

# Project Download
```Bash
git clone https://github.com/Skwardlow/Diploma.git
```

# Program assembly

### Setting up Python dependencies and env variables
```Bash
cd BotApi/app/
python3 -m venv venv
virtualenv venv
source bin/venv/activate
pip3 install -r requirements.txt
export FLASK_APP=app
```

#### You need a Gradle version 5.6 and higher!

##### Service-side
```Groovy
gradle build -x test
```

##### Predictor-side
 * Not neccessary

# Program launch
##### Service-side
```Groovy
gradle bootRun
```

##### Predictor-side
```Bash
flask run
```

### [Link to the project](https://instabotdetector.xyz/)

##### Used technologies 
![Image](https://lilly021.com/wp-content/uploads/2019/07/springBoot_featured_image.png)
![Image](https://i.ytimg.com/vi/ClM3T7uozEo/maxresdefault.jpg)
![Image](https://pbs.twimg.com/media/Ch-UM1wWEAISZac.jpg)
![Image](https://static.tildacdn.com/tild3830-6137-4139-b266-323735306638/IG-Glyph-Icon-hero.png)
![Image](https://neurohive.io/wp-content/uploads/2019/06/1200px-Scikit_learn_logo_small.svg.png)
![Image](https://linux-notes.org/wp-content/uploads/2019/06/Ustanovka-heroku-v-UnixLinux-660x320.jpg)
![Image](http://www.johncanessa.com/wp-content/uploads/2017/03/rest_api_logo.jpg)



## The project was made by:
* [Dmitry Gorskov](https://github.com/Skwardlow) 
