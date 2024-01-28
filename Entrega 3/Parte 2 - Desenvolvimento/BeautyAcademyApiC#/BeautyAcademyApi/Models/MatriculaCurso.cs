using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace BeautyAcademyApi.Models
{
    [Table("MatriculadeCursos")]
    public class MatriculaCurso
    {
        [Key]
        public int IdMatriculaCurso { get; set; }

        [ForeignKey("Aluno")]
        public int Matricula { get; set; }

        [ForeignKey("Curso")]
        public int IdCurso { get; set; }


        [JsonIgnore]
        public Aluno? Aluno { get; set; }

        public Curso? Curso { get; set; }
    }
}
