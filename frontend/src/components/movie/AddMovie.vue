<template>
  <v-card class="pa-5" outlined tile raised>
    <v-list-item three-line>
      <v-list-item-content>
        <div class="overline mb-4">Put movie name and genre</div>
        <v-list-item-title class="headline mb-1">Add Movies</v-list-item-title>
      </v-list-item-content>
    </v-list-item>
    <v-form ref="form" v-model="valid" lazy-validation>
      <v-text-field v-model="name" :counter="30" :rules="nameRules" label="Name" required></v-text-field>

      <v-select
        v-model="genre"
        :items="genres"
        :rules="[v => !!v || 'Item is required']"
        label="Genre"
        required
      ></v-select>

      <v-btn :disabled="!valid" color="success" class="mr-4" @click="add">Add</v-btn>

      <v-btn color="error" class="mr-4" @click="reset">Reset</v-btn>

      <!-- <v-btn color="warning" @click="resetValidation">Reset Validation</v-btn> -->
    </v-form>
  </v-card>
</template>
<script>
import { mapActions } from "vuex";

export default {
  name: "AddMovie",
  data: () => ({
    valid: true,
    name: "",
    nameRules: [
      v => !!v || "Name is required",
      v => (v && v.length <= 30) || "Name must be less than 30 characters"
    ],
    genre: null,
    genres: ["Romantic", "Horror", "Thriller", "Action", "War"]
  }),
  methods: {
    add() {
      if (this.$refs.form.validate()) {
        this.snackbar = true;
        this.$store.dispatch("addMovie", {
          name: this.name,
          genre: this.genre
        });
        this.reset();
      }
    },
    reset() {
      this.$refs.form.reset();
    },
    ...mapActions(["addMovie"])
  },
  computed: {}
};
</script>