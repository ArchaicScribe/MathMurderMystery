# MathMurderMystery or MCubed #

## An app that will incorporate gaming elements with math problems, to help imporve the user's math skills. 

**Application Name: Math Murder Mystery**
The functionality of this app will feature a user trying to navigate themselves through a murder mystery and solve the crime by solving math problems. The user will be able to keep track of their score, progress, where they are in the story and can keep track of their score. The app will not necessarily need internet access; however, to compete against other player's score, they will. It will pull the question from a pool of potential question, and the app will randomly choose a question to ask the user to answer, with some of the mysteries being multiple choice or true and false type question. 

**What will your app be called?**
The app that I am proposing is currently called is Math Murder Mystery game or M^3. The reason for the naming for this game is because you are trying to solve a series of clues or hints to solve a murder utilizing mathematics and logic. 

**What is the basic functionality of the app?**
The main functionality of the app is to enhance the user's cognitive ability to work through math problems, ranging from basic arithmetic to calculus. I want to be able to have multiple levels, maps, murder scenarios to challenge the user(s) and have a progression system. 

**Who would find this app useful or fun, and when would they use it?**
User 1, The Math Student
Math students, whether in elementary, middle, high school or higher education all are looking for a way to challenge themselves with math and logic problems. With these types of challenges, it can become very tedious and often dull if there isn't a type of reward or goal set before them. That is where Math Murder Mystery game will come in. It will engage the user(s) to progress and challenge themselves to achieve badges or trophies to showcase to their friends and challenge others in mathematics to see who can solve the murder the quickest. Eventually, this game will allow the user(s) to prompt other players from across the world in this game and build their social network(s) and find other "mathletes" or players who share their same interests. 

**Could this app be useful on its own, with no connection to the Internet?**
Yes, this app will still allow players to play offline on their own. They will not be able to update their rankings or trophies until they can reconnect to the internet and update through the server.

**What sort of data would this app use or share if it had a connection to the Internet?**
The data that would be shared would be user's rankings, trophies, and global view of other players' awards, rankings, and status. 

 In Math Murder Mystery or M Cubed, SQL will be utilized by storing the math problems that will be used in the game. By keeping track of the math problems, their difficulties, and how they will be used in each level will all be completed through the database. Also, keeping track of the player's progress throughout the game will come into play as well. Using LEFT, RIGHT, and FULL JOIN in the program to compartmentalize and organize all of the player's data and history. Using queries, if the player wants to see a detail of their progress within the game will also come in handy for them to see and read about during the game.

## Unimplemented/Incomplete Element of Math Murder Mystery ##
* Need to have more scenarios, levels, and rooms implemented.
* Need to have more question available. 
* Would like to have more artwork incorporated into the game itself. 
* ListView is working, but needs to display the scores and user names. 

## User Stories ##
[User Stories](https://github.com/ArchaicScribe/MathMurderMystery/blob/master/docs/userStories.md)


**Android API version and Hardware**
* Samsung Galaxy Note 9
* Android API 27
* Nexus 5x emulator

**Third Party Libraries Utilized**
* Room
* [Stehto](https://github.com/facebook/stetho)
* [Retrofit](https://square.github.io/retrofit/)
* [GSON](https://github.com/google/gson)
* [Deep Dive Coding Android Utilities/BaseFluentAsyncTask](https://github.com/deep-dive-coding-java/android-utilities)

**Potential Future for Math Murder Mystery**
As this app progresses further into development, having more problems and a variety of puzzles could add a myriad of new challenges to the users. Even with the data structure as is, having it be implemented into another game would be another avenue that could be explored. Because of the structure, having this model integrated into another game could be an exciting idea. I want to add in more levels, scenarios, and rooms to the project as well. 

**DDL**
* [DDL](https://github.com/ArchaicScribe/MathMurderMystery/blob/master/docs/ddl.sql.md)

**ERDs**
* [ERD Diagram](https://drive.google.com/file/d/1LKRuEyf0FsU06t3hBMaPJ-Bphsx4FxDr/view?usp=sharing)

**JavaDocs**
* [JavaDocs](docs/api/)

## Third Party Libraries Used ## 

    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support:support-v4:28.0.0'
    implementation 'com.android.support:design:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    implementation 'com.github.deep-dive-coding-java:android-utilities:1.0.0'
    implementation 'org.apache.commons:commons-csv:1.6'
    implementation 'com.facebook.stetho:stetho:1.5.0'
    implementation 'android.arch.persistence.room:runtime:1.1.1'
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    annotationProcessor 'android.arch.persistence.room:compiler:1.1.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    androidTestImplementation 'com.android.support.test:rules:1.0.2'

## External Services ##
The only external service utilized for this app was [Open Trivia Database](https://opentdb.com/api_config.php)

## Basic Instructions for user for building MCubed ##
1. Clone the repository to the local Android Studio project.
2. The repository for the app is located on [Github](https://github.com/ArchaicScribe)
3. Go to your IDE and choose to check out from version control utilizing GIT. 
4. Paste URL, that was copied, into a browser and go to [Github.](https://github.com/ArchaicScribe) 
5. To build and run your app, select Run > Run in the menu bar (or click Run in the toolbar). Android Studio asks you to select a deployment target. Select a device to install and run your app. 
6. Be sure to build the app onto a device running a minimum of API 21.
7. You will not need an API Key because the questions are preloaded already onto the database. 
8. It's recommended that you the default Grade wrapper (recommended) for when executing the Gradle and ensure that the Gradle JVM (Java Virtual Machine) is set to Java 1.8x version. 

## Instructions for Using MCubed ##
1. Clone the Git repository located at https://github.com/ArchaicScribe/MathMurderMystery, to create a local clone of the repository.
2. You will not be required to acquire an API Key, as all of the questions will be pre-loaded into the database. 
3. At the main screen fragment, you will then be able to select from the navigation drawer menu which fragment you would like to select. 
4. When you choose the Play Fragment, you will enter into the game. 
5. From here, you will be able to determine which scenario, level, and room you would like to enter and play. 
6. Once you have selected this, then you will be presented with math problems, either true and false or multiple choice questions. 
7. The end-user will be able to hit the back button to return to the previous fragment they selected initially. 

## [Copyright and License for Math Murder Mystery](https://github.com/ArchaicScribe/MathMurderMystery/blob/master/LICENSE) ##

## [Full copyright & license notices](https://github.com/ArchaicScribe/MathMurderMystery/blob/master/NOTICE.md) ##
