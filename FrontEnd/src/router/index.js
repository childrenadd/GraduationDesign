import Vue from 'vue'
import Router from 'vue-router'
import Stitches from '@/components/Stitches'
import Login from '@/components/Login'
import Register from '@/components/Register'
import InfoEdit from '@/components/InfoEdit'
import Poster from '@/components/Poster'
import Index from '@/components/Index'
import Test from '@/components/Test'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/index'
    },{
      path: '/index',
      component: Index
    },
    {
      path: '/stitches',
      component: Stitches
    },{
      path: '/poster',
      component: Poster
    },
    {
      path: '/login',
      component: Login
    },{
      path: '/register',
      component: Register
    },{
      path: '/infoEdit',
      component: InfoEdit
    },{
      path: '/test',
      component: Test
    }
  ]
})
