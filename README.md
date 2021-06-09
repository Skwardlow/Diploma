[![Build Status](https://travis-ci.com/Skwardlow/Diploma.svg?token=KCkKDpGCxsPEM3xKfkFv&branch=master)](https://travis-ci.com/github/Skwardlow/Diploma)

# InstaFakeDetector

# Project Download
```Bash
git clone https://github.com/Skwardlow/Diploma.git
```

### Setting up Python dependencies
```Bash
cd BotApi/app/
pip3 install virtualenv
virtualenv venv
source bin/venv/activate
pip install -r requirements.txt
```

# Program assembly

##### Service-side
```Groovy
gradle build -x test
```

##### Predictor-side
```Bash
flask run
```

# Program launch
```Groovy
gradle bootRun
```
#### Gradle version 5.6 and higher

# InstaFakeDetector 
##### This service is intended to help in determining whether the profile of the social network Instagram belongs to the class of bots. Determination of belonging is based on a neural network specially trained on a dataset of fake accounts, which makes its decision.
 1. It's simple. Start the service-side, predictor-side as above.
 2. Open the web application page.
 3. You will be presented with one input field and a "Check" button, by clicking on which, after a short period of time, you will receive the result.
 4. Enter the name of your Instagram account, click the button and get the result!

### [Link to the project](https://instafakepredictor.herokuapp.com/)

##### Used technologies 
![Image](https://lilly021.com/wp-content/uploads/2019/07/springBoot_featured_image.png)
![Image](https://i.ytimg.com/vi/ClM3T7uozEo/maxresdefault.jpg)
![Image](https://pbs.twimg.com/media/Ch-UM1wWEAISZac.jpg)
![Image](https://linux-notes.org/wp-content/uploads/2019/06/Ustanovka-heroku-v-UnixLinux-660x320.jpg)
![Image](http://www.johncanessa.com/wp-content/uploads/2017/03/rest_api_logo.jpg)
![Image](https://static.tildacdn.com/tild3830-6137-4139-b266-323735306638/IG-Glyph-Icon-hero.png) https://neurohive.io/wp-content/uploads/2019/06/1200px-Scikit_learn_logo_small.svg.png
![Image](https://neurohive.io/wp-content/uploads/2019/06/1200px-Scikit_learn_logo_small.svg.png)


## The project was made by:
* [Dmitry Gorskov](https://github.com/Skwardlow) 
