<template>
    <v-card class="pa-5" outlined tile raised>
        <v-list-item>
            <v-list-item-content>
                <div class="overline mb-4">My list of movies</div>
                <v-list-item-title class="headline mb-1">Movie List</v-list-item-title>
            </v-list-item-content>
        </v-list-item>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-center">Name</th>
                    <th class="text-center">Genre</th>
                    <th class="text-center">Remove</th>
                    <th class="text-center">Edit</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="(movie, index) in movies" :key="movie.name">
                    <td>{{ movie.name }}</td>
                    <td>{{ movie.genre }}</td>
                    <td>
                        <v-btn fab x-small dark color="error" @click="removeMovie(movie, index)">
                            <v-icon>mdi-delete</v-icon>
                        </v-btn>
                    </td>
                    <td>
                        <v-btn fab x-small dark color="primary" @click="editMovie(index)">
                            <v-icon>mdi-pencil</v-icon>
                        </v-btn>
                    </td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
    </v-card>
</template>
<script>
    import {mapActions} from "vuex";

    export default {
        name: "MovieList",
        data() {
            return {};
        },
        methods: {
            removeMovie(movie, index) {

                this.$store.dispatch("removeMovie", movie);
            },
            editMovie(index) {
                this.$store.dispatch("editMovie", index);
            },
            ...mapActions(["removeMovie", "editMovie"])
        },
        computed: {
            movies() {
                return this.$store.getters.fetchAllMovies;
            }
        },
        created() {
            this.$store.dispatch('loadMovies');
        }
    };
</script>