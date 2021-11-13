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
![image](https://user-images.githubusercontent.com/57287911/137589168-22df9323-6176-42a0-bde8-3e9639ad152b.png)
* DDos - Cloudflare
* Man In The Middle - Https
* Cross Site Scripting - CSRF
* SQL Injection - Spring Data
* Identity Spoofing - Login Token/Login Throttling
* Botting - Captcha/Email Verification

# Deployment
*minimally, this section contains a public URL of the app. A description of how your software is deployed is a bonus. Do you do this manually, or did you manage to automate? Have you taken into account the security of your deployment process?*




