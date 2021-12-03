# Table of contents
* [Goal](#goal)
* [User Stories with Acceptance criteria](#user-stories-with-acceptance-criteria)
* [Workspace](#workspace)
* [Threat model](#threat-model)
* [ Additional best security practices used](#additional-best-security-practices-used)
* [Deployment](#deployment)



# Goal
*The share-a-plate app will reduce food waste, provide food for the hungry in need and above that helps building social relations in the community*

# User Stories with Acceptance criteria

## As a visitor  I can register  So that I can become a valid member
* I can navigate to a registration page
* I can fill in a registration form
* I can confirm my registration with a verification link sent by email


## As a member   I can login So that I have access to the sharing functionalities
* I can navigate to a login page
* I can fill in a login form
* I can access my personal profile page
* I can access the sharing page


## As a logged in member I can share a plate So that other members can accept it and pick it up
* I can created a plate to share
* I can specify the kind of food
* I can specify the the amount(s) of food
* I can specify the pickup time
* I can specify the pickup place
* I can add other useful info


## As a logged in member I can accept a shared plate So that I can notify the sharing member that I’ll pick it up when ready
* I can accept a shared plate
* I can notify the sharing member about it
* I can send other useful info to the sharing member


## As a logged in member I can deactivate my membership  So that all my data is removed from the application database.
* I can choose to deactivate my memberschip by clicking a button on my personal profile page.


## As a logged in member   I can contact a helpdesk  So that I can pose any question I encounter while using the application.
* I can send a message by clicking a help-button on every pageview.

# Workspace
* https://ddt-ehb.atlassian.net/jira/software/projects/DDTE/boards/1 


# Threat model
![image](https://github.com/EHB-TI/web-app-digital-dream-team/blob/main/threat.png)
* DDos - Cloudflare
* Man In The Middle - Https
* Cross Site Scripting - CSRF
> ##### The frontend offers forms handling user input, providing the functionalities of entering user details as well as entering details of a plate to be shared. Malicious users could try to exploit these forms and search for XXS vulnerabilities. By using the the string interpolation feature of the Angular framework, we manage to secure the frontend for these kinds of attacks. 


* SQL Injection - Spring Data
> ##### By using the spring framework and using parameters for user input that is used to construct sql statements, thus constructing safe parametrized sql statements.

* Identity Spoofing - Login Token/Login Throttling
> ##### By using a JWT verification Token, we prevent spoofing attempts 


* Botting - Captcha/Email Verification

# Additional best security practices used
> ##### Avoided the use of innerHTML

> Never concatenated user input as a string and send it as such to any template

> Avoid non-Angular template engines on server side

> produce log files for monitoring purposes

# Deployment

https://www.digitaldreamteam.be




