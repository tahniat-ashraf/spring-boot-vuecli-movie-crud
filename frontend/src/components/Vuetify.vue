<template>
    <div>
        <v-alert
                color="blue"
                text
                icon="mdi-vuetify"
                border="left"
        >
            Powered by Vuetify
        </v-alert>
    </div>
</template>

<script>
    export default {
        name: 'Vuetify',
        props: {
            source: String,
        },
        data() {
            return {
                drawer: null
            }
        },
    }
</script>