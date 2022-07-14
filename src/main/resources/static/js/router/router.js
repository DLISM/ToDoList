import Vue from 'vue'
import VueRouter from 'vue-router'
import login from 'pages/login.vue'
import registration from 'pages/registration.vue'
import profile from 'pages/profile.vue'
import main from 'pages/main.vue'

Vue.use(VueRouter)

const routes=[
    {path:"/", component: main},
    {path:"/registration", component: registration},
    {path:"/login", component: login},
    {path:"*", component: profile}
]

export default new VueRouter({
    routes
})
