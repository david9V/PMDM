import React, { Component } from "react";
import PersonDataService from "../services/person.service";

export default class PersonAdd extends Component {
  constructor(props) {
    super(props);
    this.onChangeFirstName = this.onChangeFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangeStreet = this.onChangeStreet.bind(this);
    this.onChangePostalCode = this.onChangePostalCode.bind(this);
    this.onChangeCity = this.onChangeCity.bind(this);
    this.onChangeBirthday = this.onChangeBirthday.bind(this);
    this.addPerson = this.addPerson.bind(this);
    this.check = this.check.bind(this);
    
    this.state = {
      currentPerson: {
        firstName: "",
        lastName: "",
        street: "",
        postalCode: "",
        city: "",
        birthday: ""
      },
      message: "Rellene los datos"
    };
  }

  onChangeFirstName(e) {
    const firstName = e.target.value;

    this.setState(function(prevState) {
      return {
        currentPerson: {
          ...prevState.currentPerson,
          firstName: firstName
        }
      };
    });
  }

  onChangeLastName(e) {
    const lastName = e.target.value;

    this.setState(function(prevState) {
      return {
        currentPerson: {
          ...prevState.currentPerson,
          lastName: lastName
        }
      };
    });
  }
  
  onChangeStreet(e) {
    const street = e.target.value;

    this.setState(function(prevState) {
      return {
        currentPerson: {
          ...prevState.currentPerson,
          street: street
        }
      };
    });
  }

  onChangePostalCode(e) {
    const postalCode = e.target.value;

    this.setState(function(prevState) {
      return {
        currentPerson: {
          ...prevState.currentPerson,
          postalCode: postalCode
        }
      };
    });
  }

  onChangeCity(e) {
    const city = e.target.value;

    this.setState(function(prevState) {
      return {
        currentPerson: {
          ...prevState.currentPerson,
          city: city
        }
      };
    });
  }

  onChangeBirthday(e) {
    const birthday = e.target.value;

    this.setState(function(prevState) {
      return {
        currentPerson: {
          ...prevState.currentPerson,
          birthday: birthday
        }
      };
    });
  }

  addPerson() {
    PersonDataService.create(
        this.state.currentPerson
      )
        .then(response => {
          console.log(response.data);
          this.setState({
            message: "¡Persona añadida con éxito!"
          });
        })
        .catch(e => {
          console.log(e);
        });
    
  }

  check(){
    
  }

  render() {
    const { currentPerson } = this.state;

    return (
      <div>
      
          <div className="edit-form">
            <h4>Datos</h4>
            <form>
              <div className="form-group">
                <label htmlFor="nombre" name="nombre">Nombre</label>
                <input
                  type="text"
                  className="form-control"
                  id="nombre"
                  value={currentPerson.firstName}
                  onChange={this.onChangeFirstName}
                />
              </div>
              <div className="form-group">
                <label htmlFor="apellidos" name="apellidos">Apellidos</label>
                <input
                  type="text"
                  className="form-control"
                  id="apellidos"
                  value={currentPerson.lastName}
                  onChange={this.onChangeLastName}
                />
              </div>
              <div className="form-group">
                <label htmlFor="calle" name="calle">Calle</label>
                <input
                  type="text"
                  required
                  className="form-control"
                  id="calle"
                  value={currentPerson.street}
                  onChange={this.onChangeStreet}
                />
              </div>
              <div className="form-group">
                <label htmlFor="cp" name="cp">Código postal</label>
                <input
                  type="number"
                  className="form-control"
                  id="cp"
                  value={currentPerson.postalCode}
                  onChange={this.onChangePostalCode}
                />
              </div>
              <div className="form-group">
                <label htmlFor="ciudad" name="ciudad">Ciudad</label>
                <input
                  type="text"
                  className="form-control"
                  id="ciudad"
                  value={currentPerson.city}
                  onChange={this.onChangeCity}
                />
              </div>
              <div className="form-group">
                <label htmlFor="fechnac" name="fechnac">Fecha de nacimiento</label>
                <input
                  type="date"
                  className="form-control"
                  id="fechnac"
                  value={currentPerson.birthday}
                  onChange={this.onChangeBirthday}
                />
              </div>
            </form>

            <p><b>{this.state.message}</b></p>

            <button
              type="submit"
              className="badge badge-success"
              onClick={this.check}
            >
              Añadir persona
            </button>
            <br></br>
          </div>
      </div>
    );
  }
}
