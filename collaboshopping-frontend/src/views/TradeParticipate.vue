
<!-- TradeParticipate.vue -->
<script>
// @ is an alias to /src
import '../plugins/vuetify.js'
import '../plugins/webfontloader.js'
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import {ref} from 'vue'
import {useField, useForm} from 'vee-validate'

export default {
  name: 'TradeParticipate',
  components: {
    MainHeader,
    MainFooter
  }
}
</script>
<script setup>


import api from "@/plugins/axios.js";
import {TOKEN_KEY} from "../../common/variable.js";

const {handleSubmit, handleReset} = useForm({
  validationSchema: {
    purchaseCount(value) {
      if (value?.length >= 1 && /[0-9-]+/.test(value)) return true

      return '수량을 입력해주세요.'
    },
    checkbox(value) {
      if (value === '1') return true
      return 'Must be checked.'
    },
  },
})
const title = useField('title')
const tradeId = useField('tradeId')
const product = useField('product')
const tradeMemberName = useField('tradeMemberName')
const purchaseCount = useField('purchaseCount')
const totalPrice = useField('totalPrice')
const checkbox = useField('checkbox')

const submit = handleSubmit(values => {
  //alert(JSON.stringify(values, null, 2))
  api.post("/api/v1/tradeDetails/participate", JSON.stringify(values, null, 2), {
    headers: {
      "Content-Type": `application/json`,
    },
  }).then((res) => {
    console.log("---axios Post 성공---- ");



  }).catch(error => {
    console.log(error.response);
    alert(error.response.data.code);
  });
})
</script>

<template>
  <MainHeader/>
  <div style="width:50%;">
    <form @submit.prevent="submit">

      <v-text-field
          v-model="title.value.value"
          label="제목"
      ></v-text-field>

      <v-text-field
          v-model="tradeId.value.value"
          label="거래번호"
      ></v-text-field>

      <v-text-field
          v-model="product.value.value"
          label="상품명"
      ></v-text-field>

      <v-text-field
          v-model="tradeMemberName.value.value"
          label="등록자명"
      ></v-text-field>

      <v-text-field
          v-model="purchaseCount.value.value"
          :error-messages="purchaseCount.errorMessage.value"
          label="주문수량"
      ></v-text-field>

      <v-text-field
          v-model="totalPrice.value.value"
          label="총금액"
      ></v-text-field>


      <v-checkbox
          v-model="checkbox.value.value"
          label="공동구매 입찰 확인"
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