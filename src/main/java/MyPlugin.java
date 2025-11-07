import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.buildServer.messages.serviceMessages.Message;

import java.util.Objects;

/**
 * Пользовательский плагин для IntelliJ IDEA, который закрывает текущий открытый файл
 *
 * <p>Этот плагин выполняет операцию
 * закрытия файла при активации действия
 * ctrl + alt + /.</p>
 *
 * <p><b>Пример использования:</b> в любом открытом окне
 * используйте ctrl + alt + / чтоб закрыть файл.</p>
 *
 * @author Timur
 * @version 1.0
 */
public class MyPlugin extends AnAction {
    /**
     * Выполняет основное действие плагина при активации горячей клавиши.
     *
     * <p>Метод получает текущий открытый файл из редактора, закрывает его
     * и отображает диалоговое окно с подтверждением операции.</p>
     *
     * @param event событие действия
     */
    @Override
    public void actionPerformed(AnActionEvent event){
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(Objects.requireNonNull(event.getProject()));
        VirtualFile currentFile = fileEditorManager.getSelectedFiles()[0];

        if (currentFile != null){
            fileEditorManager.closeFile(currentFile);
            Messages.showMessageDialog("File was successfully closed", "My plugin", Messages.getInformationIcon());
        }
    }
}