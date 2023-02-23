import React, { Component } from "react";
import PersonDataService from "../services/person.service";

export default class PersonSearch extends Component {
  constructor(props) {
    super(props);
    this.onChangeSearchFirstName = this.onChangeSearchFirstName.bind(this);
    this.retrievePersons = this.retrievePersons.bind(this);
    this.searchFirstName = this.searchFirstName.bind(this);
    this.state = {
      persons: [],
      searchFirstName: ""
    };
  }
  componentDidMount() {
    this.retrievePersons();
  }

  sendData = () => {
    this.props.parentCallback(this.state.persons);
  }

  onChangeSearchFirstName(e) {
    const searchFirstName = e.target.value;

    this.setState({
      searchFirstName: searchFirstName
    });
  }

  retrievePersons() {
    PersonDataService.getAll()
      .then(response => {
        this.setState({
          persons: response.data
        });
        this.sendData();
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  searchFirstName() {
    PersonDataService.get(this.state.searchFirstName)
      .then(response => {
        this.setState({
          persons: response.data
        });
        this.sendData();
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  render() {
    const { searchFirstName, persons } = this.state;
    return (
      <div className="list row">
        <div className="col-md-10">
          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              placeholder="Buscar por nombre"
              value={searchFirstName}
              onChange={this.onChangeSearchFirstName}
            />
            <div className="input-group-append">
              <button
                className="btn btn-outline-secondary"
                type="button"
                onClick={this.searchFirstName}
              >
                Buscar
              </button>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
