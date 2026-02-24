jdk_tool = 'java-21'
maven_install = 'openpay-maven-3.9.6'
aws_account = 'openpay'

libraries {
	maven
	ecr
}

application_environments {
    dev {
    	ignore = true
    	ecr_registry = '378653672129.dkr.ecr.us-east-1.amazonaws.com'
        ecr_region = 'us-east-1'
        ecr_repo_name = ''
		ecs_cluster = ''
		ecs_service = ''
    }
    
    qa {
    	ignore = true
    	ecr_registry = '378653672129.dkr.ecr.us-east-1.amazonaws.com'
        ecr_region = 'us-east-1'
        ecr_repo_name = ''
		ecs_cluster = ''
		ecs_service = ''
    }
    
    sandbox {
    	ignore = true
    	ecr_registry = '378653672129.dkr.ecr.us-east-1.amazonaws.com'
        ecr_region = 'us-east-1'
        ecr_repo_name = ''
		ecs_cluster = ''
		ecs_service = ''
    }
    
    prod {
    	ignore = true
    	ecr_registry = '250557226785.dkr.ecr.us-east-1.amazonaws.com'
        ecr_region = 'us-east-1'
        ecr_repo_name = ''
		ecs_cluster = ''
		ecs_service = ''
    }
}
