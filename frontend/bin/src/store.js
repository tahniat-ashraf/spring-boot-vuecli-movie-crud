import Vue from "vue";
import Vuex from "vuex";
import api from "@/components/backend-api";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    movies: [],
    editVisibility: false,
    onEditMovieIndex: -1
  },
  mutations: {
    add(state, movie) {
      state.movies.push(movie);
    },
    remove(state, movie) {
      const index = state.movies.indexOf(movie);
      state.movies.splice(index, 1);
    },
    edit(state, index) {
      state.editVisibility = true;
      state.onEditMovieIndex = index;
    },
    save(state, payload) {
      state.movies[state.onEditMovieIndex].genre = payload.genre;
      state.movies[state.onEditMovieIndex].name = payload.name;
      state.onEditMovieIndex = -1;
      state.editVisibility = false;
    },
    loadMovies(state, movies) {
      state.movies = movies;
    }
  },
  actions: {
    loadMovies(context) {
      api.findAllMovies().then(response => {
        console.log(response.data);
        context.commit("loadMovies", response.data);
      });
    },
    addMovie(context, movie) {
      api
        .saveMovie(movie)
        .then(response => {
          console.log(response.data);
          context.commit("add", response.data);
        })
        .catch(error => {
          console.error(error);
        });
    },
    removeMovie(context, movie) {
      api
        .deleteMovie(movie)
        .then(response => {
          console.log(response.data);
          context.commit("remove", movie);
        })
        .catch(error => {
          console.error(error);
        });
    },
    editMovie(context, index) {
      context.commit("edit", index);
    },
    saveMovie(context, movie) {
      api
        .saveMovie(movie)
        .then(response => {
          console.log(response.data);
          context.commit("save", movie);
        })
        .catch(error => {
          console.error(error);
        });
    }
  },
  getters: {
    onEditMovie(state) {
      return { ...state.movies[state.onEditMovieIndex] };
    }
  },
  modules: {}
});
