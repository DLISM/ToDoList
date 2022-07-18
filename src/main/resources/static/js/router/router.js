import Vue from 'vue'
import VueRouter from 'vue-router'
import registration from 'pages/registration.vue'
import main from 'pages/main.vue'
import login from 'pages/login.vue'

Vue.use(VueRouter)

const routes=[
    {
        name:'main',
        path:"/",
        component: main
    },
    {
        path:"/login",
        name:'login',
        component: login
    },
    {
        name:'register',
        path:"/register",
        component: registration
    },
    {path:"*", component: main},
]

export default new VueRouter({
    routes
})
