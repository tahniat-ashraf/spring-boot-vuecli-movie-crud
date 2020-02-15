<template>
    <div class="service">

        <button @click="callHelloApi()">Call Spring Boot REST backend service</button>

        <div class="backend_response">
            <p><b>Backend response:</b>  {{ backendResponse }}</p>

        </div>

    </div>
</template>

<script>
    import api from "./backend-api";

    export default {
        name: 'service',

        data() {
            return {
                backendResponse: '-',
                errors: []
            }
        },
        methods: {
            // Fetches posts when the component is created.
            callHelloApi() {
                api.hello().then(response => {
                    this.backendResponse = response.data;
                    console.log(response.data)
                })
                    .catch(error => {
                        this.errors.push(error)
                    })
            }
        }
    }

</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }

    .backend_response {
        padding-top: 20px;
    }
    button{
        background-color: #E5E5E5;
        padding: 5px;
    }
</style>
