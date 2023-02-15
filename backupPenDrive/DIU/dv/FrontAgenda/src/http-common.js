import axios from "axios";

export default axios.create({
  baseURL: "http://pruebadiubt-env.eba-jnmuqpit.us-east-1.elasticbeanstalk.com/",
  headers: {
    "Content-type": "application/json",
    'Access-Control-Allow-Origin' : '*',
    'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS'
  }
});