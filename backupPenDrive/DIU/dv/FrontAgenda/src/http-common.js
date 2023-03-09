import axios from "axios";
//baseURL: "http://localhost:8080/"
export default axios.create({
  baseURL: "http://pruebadiubt-env.eba-jnmuqpit.us-east-1.elasticbeanstalk.com",
  headers: {
    "Content-type": "application/json",
    'Access-Control-Allow-Origin' : '*',
    'Access-Control-Allow-Methods':'GET,PUT,POST,DELETE,PATCH,OPTIONS'
  }
});