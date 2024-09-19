<script setup lang="ts">
import { RouterLink, useRoute } from "vue-router"
import AssetsIcon from "../icon/AssetsIcon.vue"
import AssetsIconSelected from "../icon/AssetsIconSelected.vue"
import { computed } from "vue"

const route = useRoute()
const isActive = computed(() => {
  return route.path.includes("/asset")
})
</script>

<template>
  <RouterLink to="/asset" class="flex flex-col justify-center items-center mt-2">
    <component :is="isActive ? AssetsIconSelected : AssetsIcon" />
    <p class="text-sm mt-1">자산</p>
  </RouterLink>
</template>
