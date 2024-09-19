<script setup lang="ts">
import { RouterLink, useRoute } from "vue-router"
import { computed } from "vue"
import StockIcon from "../icon/StockIcon.vue"
import StockIconSelected from "../icon/StockIconSelected.vue"

const route = useRoute()
const isActive = computed(() => {
  return route.path.includes("/stock")
})
</script>

<template>
  <RouterLink to="/stock" class="flex flex-col justify-center items-center mt-2">
    <component :is="isActive ? StockIconSelected : StockIcon" />
    <p class="text-sm mt-1">자산</p>
  </RouterLink>
</template>
