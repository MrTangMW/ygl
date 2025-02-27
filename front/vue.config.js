module.exports={
	devServer:{
		disableHostCheck: true,
		 proxy: {
		      '/pages': {
		        target: "http://2.0.3.70:8082/uni-tmnl"
		      }
		    },
	}
}