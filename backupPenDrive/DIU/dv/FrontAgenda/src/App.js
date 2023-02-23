import React, { Component } from "react";
import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap/dist/css/bootstrap.css';
import "./App.css";
import PersonList from "./components/persons-list.component";
import PersonSearch from "./components/person-search-component";


class App extends Component {
  constructor() {
    super();
    this.state = {
      persons: []
    };
  }

  callbackFunction = (childData) => {      
    this.setState({persons: childData})
  }
  
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            Agenda
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/add"} className="nav-link">
                Add
              </Link>
            </li>
            <li className="nav-item">
              <PersonSearch parentCallback={this.callbackFunction}></PersonSearch>
            </li>
          </div>
        </nav>

        <div className="container mt-3">
         <PersonList personList={this.state.persons}></PersonList>
        </div>
      </div>
      
    );
  }
}

export default App;
