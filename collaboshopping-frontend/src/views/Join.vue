<!-- Join.vue -->
<script>
// @ is an alias to /src
import '../plugins/vuetify.js'
import '../plugins/webfontloader.js'
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import { ref } from 'vue'
import { useField, useForm } from 'vee-validate'

export default {
  name: 'Join',
  components: {
    MainHeader,
    MainFooter
  }
}
</script>
<script setup>


import api from "@/plugins/axios.js";

const { handleSubmit, handleReset } = useForm({
  validationSchema: {
    name (value) {
      if (value?.length >= 2) return true

      return 'Name needs to be at least 2 characters.'
    },
    phone (value) {
      if (value?.length > 9 && /[0-9-]+/.test(value)) return true

      return 'Phone number needs to be at least 9 digits.'
    },
    email (value) {
      if (/^[a-z.-]+@[a-z.-]+\.[a-z]+$/i.test(value)) return true

      return 'Must be a valid e-mail.'
    },
    pw (value) {
      if(value?.length >= 2) return true

      return 'Name needs to be at least 2 characters.'
    },
    select (value) {
      if (value) return true

      return 'Select an item.'
    },
    checkbox (value) {
      if (value === '1') return true

      return 'Must be checked.'
    },
  },
})
const name = useField('name')
const phone = useField('phone')
const email = useField('email')
const select = useField('select')
const checkbox = useField('checkbox')
const pw = useField('pw')

const items = ref([
  'Item 1',
  'Item 2',
  'Item 3',
  'Item 4',
])

const submit = handleSubmit(values => {
  alert(JSON.stringify(values, null, 2))
  api.post("/join",JSON.stringify(values, null, 2),{
    headers: {
      "Content-Type": `application/json`,
    },
  }).then((res) => {
    console.log("---axios Post 성공---- ");
    this.data = res.data;
    console.log(res.data);
  }).catch(error =>{
    console.log(error.response);
  });
})
</script>

<template>
  <MainHeader/>
  <div style="width:50%;">
    <form @submit.prevent="submit">
      <v-text-field
          v-model="name.value.value"
          :counter="10"
          :error-messages="name.errorMessage.value"
          label="이름"
      ></v-text-field>

      <v-text-field
          v-model="phone.value.value"
          :counter="7"
          :error-messages="phone.errorMessage.value"
          label="휴대폰번호"
      ></v-text-field>

      <v-text-field
          v-model="email.value.value"
          :error-messages="email.errorMessage.value"
          label="E-mail"
      ></v-text-field>

      <v-text-field
          v-model="pw.value.value"
          :error-messages="pw.errorMessage.value"
          label="패스워드"
      ></v-text-field>

      <v-select
          v-model="select.value.value"
          :error-messages="select.errorMessage.value"
          :items="items"
          label="Select"
      ></v-select>

      <v-checkbox
          v-model="checkbox.value.value"
          :error-messages="checkbox.errorMessage.value"
          label="Option"
          type="checkbox"
          value="1"
      ></v-checkbox>

      <v-btn
          class="me-4"
          type="submit"
      >
        submit
      </v-btn>

      <v-btn @click="handleReset">
        clear
      </v-btn>
    </form>
  </div>

</template>