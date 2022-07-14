import Vue from 'vue'
import VueRouter from 'vue-router'
import login from 'pages/login.vue'
import registration from 'pages/registration.vue'

Vue.use(VueRouter)

const routes=[
    {path:"/login", component: login},
    {path:"/registration", component: registration}
]

export default new VueRouter({
    mode:'history',
    routes
})
