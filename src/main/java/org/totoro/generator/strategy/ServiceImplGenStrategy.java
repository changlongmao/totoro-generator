package org.totoro.generator.strategy;

import org.totoro.generator.config.BaseConfig;
import org.totoro.generator.config.GeneratorConfig;
import org.totoro.generator.config.PackageConfig;
import org.totoro.generator.config.ServiceConfig;
import org.totoro.generator.constant.GenConstant;
import org.totoro.generator.javabean.dto.ColumnDTO;
import org.totoro.generator.javabean.dto.TableDTO;
import org.totoro.generator.enums.TemplateEnum;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Mapper生成策略类
 *
 * @author ChangLF 2023/07/21
 */
public class ServiceImplGenStrategy implements GeneratorStrategy {

    @Override
    public VelocityContext getVelocityContext(BaseConfig baseConfig, Map.Entry<TableDTO, List<ColumnDTO>> tableDTOListEntry, GeneratorConfig... generatorConfigArr) {
        ServiceConfig config = (ServiceConfig) getConfig(ServiceConfig.class, generatorConfigArr);
        TableDTO tableDTO = tableDTOListEntry.getKey();

        return initVelocityContext(baseConfig, tableDTO);
    }

    @Override
    public String getTemplate() {
        return TemplateEnum.SERVICE_IMPL.getTitle();
    }

    @Override
    public String getPathname(PackageConfig packageConfig, String className) {
        return packageConfig.getJavaFileDir() + File.separator + (packageConfig.getParentPackage() + "." + packageConfig.getServiceImplPackage())
                .replaceAll("\\.", File.separator)
                + File.separator + className + GenConstant.SERVICE_IMPL_SUFFIX + GenConstant.JAVA_SUFFIX;
    }

}
