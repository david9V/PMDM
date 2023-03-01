import http from "../http-common";

class PersonDataService {
  getAll() {
    return http.get("/person");
  }

  get(firstName) {
    return http.get(`/person/name/${firstName}`);
  }

  getById(id) {
    return http.get(`/person/id/${id}`);
  }

  create(data) {
    return http.post("/person", data);
  }

  update(id, data) {
    return http.put(`/person/${id}`, data);
  }

  delete(id) {
    return http.delete(`/person/${id}`);
  }

  deleteAll() {
    return http.delete(`/person`);
  }

}

export default new PersonDataService();