.PHONY: rundev buildcore

rundev: buildcore
	@cd webapi ;\
	mvn clean ;\
	mvn quarkus:dev

buildcore:
	@cd escolacore ;\
	mvn clean ;\
	mvn install
