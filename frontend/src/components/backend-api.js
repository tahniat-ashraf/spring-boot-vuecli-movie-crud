import axios from "axios";

const baseURL = process.env.VUE_APP_API_BASE_URL+`:8098/api`;

const AXIOS = axios.create({
  baseURL: baseURL,
  timeout: 5000
});

export default {
  hello() {
    return AXIOS.get(`/hello`);
  },

  findMovieByName(name) {
    return AXIOS.post(`/findByName`, {
      name: name
    });
  },

  saveMovie(movie) {
    return AXIOS.post(`/save`, {
      name: movie.name,
      genre: movie.genre
    });
  },

  deleteMovie(movie) {
    return AXIOS.post(`/delete`, {
      name: movie.name,
      genre: movie.genre
    });
  },

  findAllMovies() {
    return AXIOS.get(`/findAll`);
  }
};
