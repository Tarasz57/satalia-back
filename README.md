# Beer homework app

This project was made with [Create React App](https://github.com/facebook/create-react-app) and Java spring boot.

## To run locally

First you'll have to build both API and Frontend images. Use the following command inside `satalia-back` folder to build API:

### `docker build . -t java-docker`

And the following one inside `satalia-front` for the frontend:

### `docker build . -t dockerized-react`

After that, running the app is as simple as `docker compose up -d`. 
Application will be reachable from your web browser at `http://localhost:3000`.