<template>
  <v-card class="pa-5" outlined tile raised>
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">Modify Movie Info</div>
        <v-list-item-title class="headline mb-1">Edit Movie</v-list-item-title>
      </v-list-item-content>
    </v-list-item>
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field v-model="movie.name" :counter="30" :rules="nameRules" label="Name" readonly></v-text-field>

      <v-select
        v-model="movie.genre"
        :items="genres"
        :rules="[v => !!v || 'Item is required']"
        label="Genre"
        required
      ></v-select>

      <v-btn :disabled="!valid" color="success" class="mr-4" @click="save">Save</v-btn>

      <v-btn color="error" class="mr-4" @click="reset">Reset</v-btn>

      <!-- <v-btn color="warning" @click="resetValidation">Reset Validation</v-btn> -->
    </v-form>
  </v-card>
</template>
<script>
import { mapActions, mapGetters } from "vuex";

export default {
  name: "EditMovie",
  data: () => ({
    valid: true,
    // name: "",
    nameRules: [
      v => !!v || "Name is required",
      v => (v && v.length <= 30) || "Name must be less than 30 characters"
    ],
    // genre: "",
    genres: ["Romantic", "Horror", "Thriller", "Action", "War"]
  }),
  methods: {
    save() {
      if (this.$refs.form.validate()) {
        this.snackbar = true;
        console.log(this.movie.name+this.movie.genre);
        this.$store.dispatch("saveMovie", {
          name: this.movie.name,
          genre: this.movie.genre
        });
        this.reset();
      }
    },
    reset() {
      this.$refs.form.reset();
    },
    ...mapActions(["saveMovie"])
  },
  computed: {
    // movie() {
    //   return this.$store.getters.onEditMovie;
    // },
    ...mapGetters({ movie: "onEditMovie" })
  }
};
</script>