import Vue from 'vue'
import VueRouter from 'vue-router'
import registration from 'pages/registration.vue'
import main from 'pages/main.vue'
import login from 'pages/login.vue'

Vue.use(VueRouter)

const routes=[
    {path:"/", component: main},
    {path:"/login", component: login},
    {path:"/registration", component: registration},
    {path:"*", component: main},
]

export default new VueRouter({
    routes
})
