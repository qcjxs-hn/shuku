<template>
    <div>
  <el-form
    ref="form"
    :model="sizeForm"
    label-width="auto"
    :label-position="labelPosition"
    :size="size"
  >
    <el-form-item label="用户名">
      <el-input v-model="sizeForm.name" />
    </el-form-item>
    <el-form-item label="生日">
      <el-col :span="11">
        <el-date-picker
          v-model="sizeForm.date1"
          type="date"
          label="Pick a date"
          placeholder="Pick a date"
          style="width: 100%"
        />
      </el-col>
      <el-col class="text-center" :span="1" style="margin: 0 0.5rem">-</el-col>
      <el-col :span="11">
        <el-time-picker
          v-model="sizeForm.date2"
          label="Pick a time"
          placeholder="Pick a time"
          style="width: 100%"
        />
      </el-col>
    </el-form-item>
    <el-form-item label="Activity type">
      <el-checkbox-group v-model="sizeForm.type">
        <el-checkbox-button label="Online activities" name="type" />
        <el-checkbox-button label="Promotion activities" name="type" />
      </el-checkbox-group>
    </el-form-item>
    <el-form-item label="Resources">
      <el-radio-group v-model="sizeForm.resource">
        <el-radio border label="Sponsor" />
        <el-radio border label="Venue" />
      </el-radio-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
    name: 'Register',
    data() {
        return {
            sizeForm: {
                name: '',
                date1: '',
                date2: '',
                type: [],
                resource: '',
            },
            labelPosition: 'left',
            size: 'small',
        }
    },
}
</script>

<style>

</style>