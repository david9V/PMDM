import React, { Component } from "react";
import PersonDataService from "../services/person.service";

export default class PersonEdit extends Component {
  constructor(props) {
    super(props);
    this.onChangeFirstName = this.onChangeFirstName.bind(this);
    this.onChangeLastName = this.onChangeLastName.bind(this);
    this.onChangeStreet = this.onChangeStreet.bind(this);
    this.onChangePostalCode = this.onChangePostalCode.bind(this);
    this.onChangeCity = this.onChangeCity.bind(this);
    this.onChangeBirthday = this.onChangeBirthday.bind(this);
    this.getPerson = this.getPerson.bind(this);
    this.updatePerson = this.updatePerson.bind(this);
    
    this.state = {
      currentPerson: {
        id: null,
        firstName: "",
        lastName: "",
        street: "",
        postalCode: "",
        city: "",
        birthday: ""
      },
      message: "Edite los campos que desee"
    };
  }



  componentDidMount() {
    this.getPerson(this.props.match.params.id);
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


  getPerson(id) {
    PersonDataService.getById(id)
      .then(response => {
        this.setState({
          currentPerson: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  updatePerson() {
    PersonDataService.update(
      this.state.currentPerson.id,
      this.state.currentPerson
    )
      .then(response => {
        console.log(response.data);
        this.setState({
          message: "¡Los datos han sido actualizados con éxito!"
        });
      })
      .catch(e => {
        console.log(e);
      });
  }

  render() {
    const { currentPerson } = this.state;

    return (
      <div>
          <div className="edit-form">
          <h4>Datos</h4>
          <form className="needs-validation">
            <div className="form-group">
              <label htmlFor="nombre" name="nombre">Nombre</label>
              <input
                type="text"
                className="form-control"
                id="nombre"
                required
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
                required
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
                required
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
                required
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
                required
                value={currentPerson.birthday}
                onChange={this.onChangeBirthday}
              />
            
            </div>

            {(currentPerson.firstName.length === 0) || (currentPerson.lastName.length === 0)
            || (currentPerson.birthday.length === 0) || (currentPerson.city.length === 0)
            || (currentPerson.postalCode.length === 0) || (currentPerson.street.length === 0)
            ?
            <button
              type="submit"
              className="btn btn-outline-success"
              >
              Actualizar datos
            </button>
            :
            <button
              type="submit"
              className="btn btn-success"
              onClick={this.updatePerson} >
              Actualizar datos
            </button>}
          </form>
        </div>
      </div>
    );
  }
}
