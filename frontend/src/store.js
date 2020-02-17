// import Vue from "vue";
// import Vuex from "vuex";
// import api from "@/components/backend-api";
//
//
// Vue.use(Vuex);
//
// export default new Vuex.Store({
//     state: {
//         movies: [{ name: "Annabelle", genre: "Horror" }],
//         editVisibility: false,
//         onEditMovieIndex: -1
//     },
//     mutations: {
//         add(state, movie) {
//             state.movies.push(movie);
//         },
//         remove(state, index) {
//             state.movies.splice(index, 1);
//         },
//         edit(state, index) {
//             state.editVisibility = true;
//             state.onEditMovieIndex = index;
//         },
//         save(state, payload) {
//             state.movies[state.onEditMovieIndex] = payload.movie;
//             state.onEditMovieIndex = -1;
//             state.editVisibility = false;
//         }
//     },
//     actions: {
//         addMovie(context, movie) {
//             context.commit("add", movie);
//         },
//         removeMovie(context, index) {
//             context.commit("remove", index);
//         },
//         editMovie(context, index) {
//             context.commit("edit", index);
//         },
//         saveMovie(context, payload) {
//             context.commit("save", payload);
//         }
//     },
//     getters: {
//         onEditMovie(state) {
//             return state.movies[state.onEditMovieIndex];
//         }
//     },
//     modules: {}
// });
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
            state.movies[state.onEditMovieIndex] = payload;
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
            })
                .catch(error => {
                    console.error(error);
                })
        },
        addMovie(context, movie) {
            api.addMovie(movie).then(response => {
                console.log(response.data);
                context.commit("add", response.data);
            })
                .catch(error => {
                    console.error(error);
                })
        },
        removeMovie(context, movie) {
            api.deleteMovie(movie).then(response => {
                console.log(response.data);
                context.commit("remove", movie);
            })
                .catch(error => {
                    console.error(error);
                })
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
            var movie = {...state.movies[state.onEditMovieIndex]};
            return movie;
        },
        fetchAllMovies(state) {
            return state.movies;
        }
    },
    modules: {}
});
