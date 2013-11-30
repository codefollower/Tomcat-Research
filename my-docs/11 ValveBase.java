    @Override
    public String getObjectNameKeyProperties() {
        StringBuilder name = new StringBuilder("type=Valve");
        
        Container container = getContainer();

		//不包含Engine的名称
        name.append(MBeanUtils.getContainerKeyProperties(container));
        
        int seq = 0;
        
        // Pipeline may not be present in unit testing
        Pipeline p = container.getPipeline();
        if (p != null) {
            for (Valve valve : p.getValves()) {
                // Skip null valves
                if (valve == null) {
                    continue;
                }
                // Only compare valves in pipeline until we find this valve
                if (valve == this) {
                    break;
                }

				//在server.xml中像这样多加几个重复的Valve就会出现这种情况:
				/*
				<Context ...>
					<Valve className="MyValve" />
					<Valve className="MyValve" />
				</Context>
				*/
				/*
				type=Valve,context=/examples,host=localhost,name=MyValve
				type=Valve,context=/examples,host=localhost,seq=1,name=MyValve
				type=Valve,context=/examples,host=localhost,name=FormAuthenticator
				type=Valve,context=/examples,host=localhost,name=StandardContextValve
				*/
                if (valve.getClass() == this.getClass()) {
                    // Duplicate valve earlier in pipeline
                    // increment sequence number
                    seq ++;
                }
            }
        }
        
        if (seq > 0) {
            name.append(",seq=");
            name.append(seq);
        }

        String className = this.getClass().getName();
        int period = className.lastIndexOf('.');
        if (period >= 0) {
            className = className.substring(period + 1);
        }
        name.append(",name=");
        name.append(className);
        
        return name.toString();
    }


设置
org.apache.catalina.connector.Request.setAsyncSupported
先遍历StandardEngine的Pipeline中的每个Valve，所有Valve都支持异步时这个请求才支持异步，
然后转到StandardHost的Pipeline ==> StandardContext的Pipeline ==> StandardWrapper的Pipeline