import { createRouter, createWebHistory, useRoute } from 'vue-router'
//import Home from '../views/Home.vue'
import Layout from '../../layout/Layout.vue'
import User from '../views/User.vue'
import Book from '../views/Book.vue'
import Booktype from '../views/Booktype.vue'
import Upload from '../views/Upload.vue'
import Tx from '../views/Tx.vue'
import Contribution from '../views/Contribution.vue'
const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: '/login',
    children: [
      {
      path: 'user',
      name: 'User',
      component: User,
      },
      {
        path: 'upload',
        name: 'Upload',
        component: Upload,
        },
        {
          path: 'tx',
          name: 'Tx',
          component: Tx,
          },
      {
        path: 'feedback',
        name: 'Feedback',
        component: () => import("../views/Feedback.vue"),
        },
        {
          path:'contribution',
          name:'Contribution',
          component:Contribution,
        },
       {
        path: 'book',
        name: 'Book',
        component: Book,
        },
        {
          path: 'booktype',
          name: 'Booktype',
          component: Booktype,
        },
    ],
  },
  {
    path: '/login',
    name: 'Login',
    component:() => import("../views/Login.vue"),
  },
  {
    path: '/register',
    name: 'register',
    component:() => import("../views/Register.vue"),
  },
 
]

const router = createRouter({
   history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
