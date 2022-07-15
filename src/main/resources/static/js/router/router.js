import Vue from 'vue'
import VueRouter from 'vue-router'
import registration from 'pages/registration.vue'
import main from 'pages/main.vue'

Vue.use(VueRouter)

const routes=[
    // {path:"/", component: main},
    {path:"/registration", component: registration},
]

export default new VueRouter({
    routes
})
