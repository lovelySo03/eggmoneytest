<script setup lang="ts">
import { RouterLink, useRoute } from "vue-router"
import { computed } from "vue"
import AllIcon from "../icon/AllIcon.vue"
import AllIconSelected from "../icon/AllIconSelected.vue"

const route = useRoute()
const isActive = computed(() => {
  return route.path.includes("/all")
})
</script>

<template>
  <RouterLink to="/all" class="flex flex-col justify-center items-center mt-2">
    <component :is="isActive ? AllIconSelected : AllIcon" />
    <p class="text-sm mt-1">전체</p>
  </RouterLink>
</template>
