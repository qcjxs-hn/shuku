<template>
<div style="margin:1% 0 0 1%; width:100%">
  <div style="margin:10px 0">
    <div>
        <el-button type="primary" @click="add">新增</el-button>
        <el-input v-model="search" size="small" placeholder="Type to search" style="width:150px;height:80%;margin:0 10px 0 0;" clearable />
        <el-button type="success" @click="load">查询</el-button>
    </div>
  </div>
    <el-table :data="filterTableData" border stripe style="width:100%">
    <el-table-column label="编号" prop="id" sortable />
    <el-table-column label="上传用户id" prop="uploader" sortable />
    <el-table-column label="上传书籍id" prop="uploadedbook" sortable/>
    <el-table-column  label="上传日期"  prop="uploadeddate" />
    <el-table-column align="right">
      

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
    title="上传编辑"
    width="30%"
    :before-close="handleClose"
     >
              <el-form :model="form" label-width="120px">
              <el-form-item label="上传用户id">
                <el-input v-model="form.uploader" />
              </el-form-item>
              <el-form-item label="上传书籍id">
                <el-input v-model="form.uploadedbook" type="textarea"/>
              </el-form-item>
              <el-form-item label="上传日期">
                <el-input v-model="form.uploadeddate" />
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
  name: 'Upload',
  components: {
    
  },
  data() {
    return {
      dialogVisible: false,
      PageNum: 1,
      pageSize: 10,
      total: 0,
      currentPage: 1,
      search: '',
      filterTableData: [
        
      ],
      form: {
        id:'',
        uploader:'',
        uploadedbook:'',
        uploadeddate:''
      },
  }
  },
  created() {
    this.load()
  },
 methods: {
  //  分页
   load(){
     request.get("/upload",{
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
   //添加
   add(){
    this.dialogVisible = true;
    // this.dialogVisible2=false;
    this.form={
    };
    // //清除历史文件
    // this.$refs['upload'].clearFiles();
   },
  //  保存
   save(){
    console.log(this.filterTableData[this.total]);
     if(this.form.id){//更新
        request.put("/upload",this.form).then(res=>{
          
          if(res.code==='200'){
          this.$message({
            message: '更新成功',
            type: 'success'
          });
          this.load();//重新加载
        } else {
          this.$message({
            message: '更新失败'+res.msg,
            type: 'error'
          })}
        });
        this.dialogVisible = false;//关闭弹窗
        
     }
     else{
      if(this.form.uploadedbook&&this.form.uploadeddate&&this.form.uploader){
     request.post("/upload",this.form).then(res=>{
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
    }else{
      this.$message({
            message: '新增失败，请填写数据！',
            type: 'error'
          });
    }
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
    // this.filterTableData.splice(index, 1);
    // console.log(index, row);
  },
  // 确认
  confirmEvent(index,row) {
    //console.log(index,row.sjyz);
    request.delete("/upload/"+row.id).then(res=>{
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
      //console.log(index)
  },
  // 取消
  cancelEvent(){
    console.log('cancel!')
  },
  }
}
</script>
