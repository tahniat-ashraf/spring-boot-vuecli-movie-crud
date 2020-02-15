import Vue from 'vue'
import Router from 'vue-router'
import Movies from "@/views/Movies.vue";

Vue.use(Router);

const router = new Router({
    mode: 'history', // uris without hashes #, see https://router.vuejs.org/guide/essentials/history-mode.html#html5-history-mode
    routes: [
        {
            path: "/",
            name: "Movies",
            component: Movies
        },
        // otherwise redirect to home
        {path: '*', redirect: '/'}
    ]
});


export default router;