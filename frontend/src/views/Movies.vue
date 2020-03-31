<template>
  <div id="movies">
    <v-app id="inspire">
      <v-container class="grey lighten-5">
        <v-row>
          <v-col>
            <AddMovie></AddMovie>
          </v-col>
          <v-col>
            <MovieList></MovieList>
          </v-col>
        </v-row>
        <v-row justify="center" v-if="editVisibility">
          <v-col cols="6">
            <EditMovie></EditMovie>
          </v-col>
        </v-row>
      </v-container>
    </v-app>
  </div>
</template>
<script>
import { mapState } from "vuex";
import AddMovie from "@/components/movie/AddMovie.vue";
import MovieList from "@/components/movie/MovieList.vue";
import EditMovie from "@/components/movie/EditMovie.vue";

export default {
  name: "Movies",
  components: {
    AddMovie,
    MovieList,
    EditMovie
  },
  computed: {
    ...mapState(["editVisibility"])
  }
};
</script>

