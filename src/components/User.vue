<template>
<div style="margin:1% 0 0 1%; width:100%">
  <div style="margin:10px 0">
    <el-button type="primary" @click="add">新增</el-button>
    <el-button type="primary">导入</el-button>
    <el-button type="success">导出</el-button>
  </div>
    <el-table :data="filterTableData" border stripe style="width:100%">
    <el-table-column style="width:2%" label="Id" prop="id" sortable />
    <el-table-column style="width:2%" label="用户名" prop="user" />
    <el-table-column style="width:2%" label="昵称" prop="nickname" />
    <el-table-column style="width:2%" label="邮箱" prop="email" />
    <el-table-column style="width:2%" label="角色" >
      <template #default="scope">
        <span v-if="scope.row.id === 1">管理员</span>
        <span v-else>普通用户</span>
      </template>
    </el-table-column>
    <el-table-column style="width:2%" label="状态" prop="success" />

    <el-table-column align="right">
      
      <template #header>
        <el-input v-model="search" size="small" placeholder="Type to search" style="width:130px;height:80%;margin:0 10px 0 0;" clearable />
        <el-button type="success" @click="load">查询</el-button>
      </template>
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.row)"
          >Edit</el-button
        >        
        <!-- 删除 -->
        <el-popconfirm
          confirm-button-text="是"
          cancel-button-text="现在还不想删除"
          :icon="InfoFilled"
          icon-color="#626AEF"
          title="你确定删除吗?"
          @confirm="confirmEvent(scope.$index, scope.row)"
          @cancel="cancelEvent"
        >
          <template #reference>
            <!-- 删除按钮 -->
                <el-button
                size="small"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)"
                >Delete</el-button
              >
          </template>
        </el-popconfirm>

      </template>
    </el-table-column>
  </el-table>
  <div style="margin:10px 0">
    <el-pagination
     @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[5, 10, 20]"
      :page-size="pageSize"
       background 
      layout="sizes, prev, pager, next, jumper" :total="total" />


       <el-dialog
    v-model="dialogVisible"
    title="添加用户"
    width="30%"
    :before-close="handleClose"
     >
     <!-- 表单 -->
              <el-form :model="form" label-width="120px">
              <el-form-item label="输入用户名">
                <el-input v-model="form.user" />
              </el-form-item>
              <el-form-item label="输入昵称">
                <el-input v-model="form.nickname" />
              </el-form-item>
              <el-form-item label="输入邮箱">
                <el-input v-model="form.email" />
              </el-form-item>
              


            </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save"
          >确定</el-button
        >
      </span>
    </template>
  </el-dialog>
  </div>
</div>
</template>

<script>
import request from '../../utils/requestff'
export default {
  name: 'User',
  components: {
    
  },
  data() {
    return {
      dialogVisible: false,
      PageNum: 1,
      pageSize: 10,
      total: 0,
      currentPage: 1,
      form: {
        user: '',
        nickname: '',
        email: '',
      
      },
      search: '',
      filterTableData: [
        
      ],

      
        
  }
  },
  created() {
    this.load()
  },
 methods: {
  //  分页
   load(){
     request.get("/user",{
      params:{
         PageNum:this.currentPage,
         PageSize:this.pageSize,
         search:this.search,
        }
     }).then(res=>{
         console.log(res)
          this.filterTableData=res.data.records;
          this.total=res.data.total;

     });
   },
  //  添加
   add(){
    this.dialogVisible = true;
    this.form={};
   },
  //  保存
   save(){
     if(this.form.id){//更新
        request.put("/user",this.form).then(res=>{
          
          if(res.code==='200'){
          this.$message({
            message: '更新成功',
            type: 'success'
          })
        } else {
          this.$message({
            message: '更新失败'+res.msg,
            type: 'error'
          })}
        });
        this.dialogVisible = false;//关闭弹窗
        this.load();//重新加载
     }
     else{
     request.post("/user",this.form).then(res=>{
       //console.log(res);
       if(res.code==='200'){
       this.$message({
         type:"success",
          message:"添加成功"
       })}else{
         this.$message({
           type:"error",
            message:"添加失败"+res.msg
         })
       }
       this.dialogVisible = false;
       this.load();
     })
     }
   },
  //  页码
  handleSizeChange(pagesize) {//每页显示多少条
    this.pageSize = pagesize;
    this.load();
    //console.log(`每页 ${val} 条`);
  },
  handleCurrentChange(pagenum) {//第几页
    this.currentPage = pagenum;
    this.load();
    //console.log(`当前页: ${val}`);
  },
  // 编辑
  handleEdit(row) {
    this.dialogVisible = true;
    this.form = JSON.parse(JSON.stringify(row));
  },
  // 删除
  handleDelete(index, row) {
    //this.filterTableData.splice(index, 1);
    console.log(index, row);
  },
  // 确认
  confirmEvent(index,row) {
    //console.log(index,row.id);
    request.delete("/user/"+row.id).then(res=>{
      if(res.code==='200'){
      this.$message({
        type:"success",
         message:"删除成功"
      })}else{
        this.$message({
          type:"error",
           message:"删除失败"+res.msg
        })
      }
      this.load();
    })
    this.filterTableData.splice(index, 1);
      console.log(index)
  },
  // 取消
  cancelEvent(){
    console.log('cancel!')
  }

}
}

</script>
