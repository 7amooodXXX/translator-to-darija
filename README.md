# Translation to Darija

AI-powered English to Moroccan Darija translation platform using Jakarta EE and Google Gemini.

---

## Project Description

This project provides an automatic translation service from **English to Moroccan Darija** using **Generative AI (Google Gemini)**.

It is composed of:
- A **secure Jakarta REST backend** (Payara Server)
- A **Chrome Extension** integrated directly into web pages
- A **PHP web client** for browser-based usage

The REST API is secured using **Jakarta Authentication (Basic Authentication)** as required in the project specification.

---

## Technologies Used

- Java 21  
- Jakarta EE 10 (JAX-RS, Jakarta Security)  
- Payara Server 7  
- Maven  
- Google Gemini API  
- Chrome Extension (Manifest V3)  
- PHP 8 (XAMPP)

---

## REST API

**Endpoint**
POST http://localhost:8080/translator/api/translate


**Request**
- JSON

---

## Security

- The REST API is secured using Jakarta Authentication – Basic Authentication.

- Unauthorized access returns HTTP 401

- Authentication is handled internally at the server level

---

## Setup Instructions

**Backend (Payara)**
- to start the Payara application serve: C:\Users\HP>C:\payara7\bin\asadmin start-domain 
- Command to build and package the project using Maven ; mvn clean package 
- Command to deploy the application to the Payara server ; C:\payara7\bin\asadmin deploy --force=true       C:\projet2\translator-service\backend-java\target\translator.war

**PHP Client**
- Place the translator folder inside: C:/xampp/htdocs/
- Access via: http://localhost/translator

**Chrome Extension**
- Open chrome://extensions
- Enable Developer Mode
- Load unpacked extension from chrome-extension folder

---

## Testing

**SoapUI**: Test secured REST endpoint with Basic Authentication

**Chrome Extension**: Select text on any page and translate via sidebar

**PHP Client**: Use web form to translate text

---

## Gemini API Key Configuration

This project uses the Google Gemini API for translation.

⚠️ **The API key is not included in the source code for security reasons.**

### Steps (Windows)

1. Open  **Environment Variables**
2. Add a **User variable** :
   - Name : `GEMINI_API_KEY`
   - Value : your Gemini API key
3. Restart the Payara server

---

## Demo Video

https://drive.google.com/file/d/1bWyY0oO6cgMuBgC2CqU0BOk7UqRViriz/view?usp=sharing


---


## Author

Developed by **Spakalw1312**







