import React, { Component } from 'react';
import { Row, Col, Container } from 'react-bootstrap';
import Table_Example from './components/TableExample';
import Form_Example from './components/FormExample';

class App extends Component {
  constructor() {
    super()
    this.state = {
      data: [], 
      word: '', 
      phonetic: '', 
      meaning: ''
    }
  }

  passParams= (data) => {
    let dataNew = this.state.data;
    dataNew.push(data) 
    this.setState({
      data: dataNew
    });
  }

 

  render() {
    return (
      <Container>
        <Row>
          <Col>
            <Form_Example passParams={this.passParams} />
          </Col>
        </Row>
        <Row>
          <Col>
            <Table_Example data={this.state.data}/>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default App;
