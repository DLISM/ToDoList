import Vue from 'vue'
import router from "./router/router";
import Vuetify from 'vuetify'
import App from 'pages/App.vue'
import 'vuetify/dist/vuetify.min.css'


Vue.use(Vuetify)

new Vue({
    el:'#app',
    router,
    render: a=>a(App)
})