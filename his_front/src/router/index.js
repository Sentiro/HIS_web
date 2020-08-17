import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Register from '../components/reg/Register';
import Login from "../components/Login";
import Main from "@/components/Main";
import RefundReg from '../components/reg/RefundReg';
import DoctorMain from'../components/doctorMain';
import Pay from '../components/reg/Pay';
import DistributeMed from '../components/reg/DistributeMed'
import Diagnose from '../components/doc/Diagnose';
import Prescription from '../components/doc/Prescription'
Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/main',
      name: 'main',
      component: Main,
      children:[
        {
        path: '/register',
        name:'register',
        component: Register
      },{
        path: '/refundReg',
        name:'refundReg',
        component: RefundReg
      },{
          path: '/pay',
          name:'pay',
          component: Pay
        },{
          path:'/distribute',
          name:'distribute',
          component:DistributeMed
        }
      ]
    },{
      path:'/login',
      name:'login',
      component: Login
    },{
      path:'/doctorMain',
      name:'doctorMain',
      component: DoctorMain,
      children:[{
        path:'/diagnose',
        name:'diagnose',
        component: Diagnose
      },{
        path:'/pre',
        name:'prescription',
        component: Prescription
      }]
    }
  ]
})
