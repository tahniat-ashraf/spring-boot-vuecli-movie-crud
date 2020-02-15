import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        movies: [{ name: "Annabelle", genre: "Horror" }],
        editVisibility: false,
        onEditMovieIndex: -1
    },
    mutations: {
        add(state, movie) {
            state.movies.push(movie);
        },
        remove(state, index) {
            state.movies.splice(index, 1);
        },
        edit(state, index) {
            state.editVisibility = true;
            state.onEditMovieIndex = index;
        },
        save(state, payload) {
            state.movies[state.onEditMovieIndex] = payload.movie;
            state.onEditMovieIndex = -1;
            state.editVisibility = false;
        }
    },
    actions: {
        addMovie(context, movie) {
            context.commit("add", movie);
        },
        removeMovie(context, index) {
            context.commit("remove", index);
        },
        editMovie(context, index) {
            context.commit("edit", index);
        },
        saveMovie(context, payload) {
            context.commit("save", payload);
        }
    },
    getters: {
        onEditMovie(state) {
            return state.movies[state.onEditMovieIndex];
        }
    },
    modules: {}
});
